var mongoose = require('mongoose'),
    Schema = mongoose.Schema;

var PerfilSchema = new Schema({
  
  creado: {
    type: Date,
    default: Date.now
  },
  
  profesion: {
    type: String,
    default: '',
    trim: true,
    required: 'la profesion no puede estar en blanco'
  },

  genero:{
      type: String,
      default:'',
      trim: true
  },

  caracteristicas: {
    type: String,
    default: '',
    trim: true
  },

  creador: {
    type: Schema.ObjectId,
    ref: 'User'
  }
});

mongoose.model('Perfil', PerfilSchema);