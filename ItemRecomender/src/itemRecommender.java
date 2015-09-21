import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

public class itemRecommender {

	public static void main(String[] args) {
		try {
			DataModel dm = new FileDataModel(new File("datos/u.csv"));
			
			TanimotoCoefficientSimilarity sim = new TanimotoCoefficientSimilarity(dm);
			
			GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(dm, sim);
			
			int x=1;
			for(LongPrimitiveIterator items = dm.getItemIDs(); items.hasNext();) {
				long itemId = items.nextLong();
				List<RecommendedItem>recommendations = recommender.mostSimilarItems(itemId, 2);
				
				for(RecommendedItem recommendation : recommendations) {
					System.out.println(" id: "+ itemId + " , " + " recomendacion: " + recommendation.getItemID() + " , " + "valor: " + recommendation.getValue());
				}
				x++;
			}
						
			
		} catch (IOException e) {
			System.out.println("hay un error.");
			e.printStackTrace();
		} catch (TasteException e) {
			System.out.println("habia una excepcion");
			e.printStackTrace();
		}
		

	}

}