// Invocar modo JavaScript 'strict' 
'use strict';

// Cargar las dependencias del módulo
var mongoose = require('mongoose'),
	Perfil = mongoose.model('Perfil');

// Crear un nuevo método controller para el manejo de errores
var getErrorMessage = function(err) {
	if (err.errors) {
		for (var errName in err.errors) {
			if (err.errors[errName].message) return err.errors[errName].message;
		}
	} else {
		return 'Error de servidor desconocido';
	}
};

// Crear un nuevo método controller para crear nuevos artículos
exports.create = function(req, res) {
	// Crear un nuevo objeto artículo
	var perfil = new Perfil(req.body);

	// Configurar la propiedad 'creador' del artículo
	perfil.creador = req.user;

	// Intentar salvar el artículo
	perfil.save(function(err) {
		if (err) {
			// Si ocurre algún error enviar el mensaje de error
			return res.status(400).send({
				message: getErrorMessage(err)
			});
		} else {
			// Enviar una representación JSON del artículo 
			res.json(perfil);
		}
	});
};

// Crear un nuevo método controller que recupera una lista de artículos
exports.list = function(req, res) {
	// Usar el método model 'find' para obtener una lista de artículos
	Perfil.find().sort('-creado').populate('creador', 'firstName lastName fullName').exec(function(err, perfiles) {
		if (err) {
			// Si un error ocurre enviar un mensaje de error
			return res.status(400).send({
				message: getErrorMessage(err)
			});
		} else {
			// Enviar una representación JSON del artículo 
			res.json(perfiles);
		}
	});
};

// Crear un nuevo método controller que devuelve un artículo existente
exports.read = function(req, res) {
	res.json(req.perfil);
};

// Crear un nuevo método controller que actualiza un artículo existente
exports.update = function(req, res) {
	// Obtener el artículo usando el objeto 'request'
	var perfil = req.perfil;

	// Actualizar los campos artículo
	perfil.profesion = req.body.profesion;
	perfil.genero = req.body.genero;
	perfil.caracteristica = req.body.caracteristica;
	// Intentar salvar el artículo actualizado
	perfil.save(function(err) {
		if (err) {
			// si ocurre un error enviar el mensaje de error
			return res.status(400).send({
				message: getErrorMessage(err)
			});
		} else {
			// Enviar una representación JSON del artículo 
			res.json(perfil);
		}
	});
};

// Crear un nuevo método controller que borre un artículo existente
exports.delete = function(req, res) {
	// Obtener el artículo usando el objeto 'request'
	var perfil = req.perfil;

	// Usar el método model 'remove' para borrar el artículo
	perfil.remove(function(err) {
		if (err) {
			// Si ocurre un error enviar el mensaje de error
			return res.status(400).send({
				message: getErrorMessage(err)
			});
		} else {
			// Enviar una representación JSON del artículo 
			res.json(perfil);
		}
	});
};

// Crear un nuevo controller middleware que recupera un único artículo existente
exports.perfilByID = function(req, res, next, id) {
	// Usar el método model 'findById' para encontrar un único artículo 
	Perfil.findById(id).populate('creador', 'firstName lastName fullName').exec(function(err, perfil) {
		if (err) return next(err);
		if (!perfil) return next(new Error('Fallo al cargar el artículo ' + id));

		// Si un artículo es encontrado usar el objeto 'request' para pasarlo al siguietne middleware
		req.perfil = perfil;

		// Llamar al siguiente middleware
		next();
	});
};

// Crear un nuevo controller middleware que es usado para autorizar una operación Perfil 
exports.hasAuthorization = function(req, res, next) {
	// si el usuario actual no es el creador del artículo, enviar el mensaje de error apropiado
	if (req.perfil.creador.id !== req.user.id) {
		return res.status(403).send({
			message: 'Usuario no está autorizado'
		});
	}

	// Llamar al siguiente middleware
	next();
};