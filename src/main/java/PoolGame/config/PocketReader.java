package PoolGame.config;

import PoolGame.objects.*;
import PoolGame.GameManager;
import java.util.ArrayList;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/** Reads in pocket section of JSON. */
public class PocketReader implements Reader {

	/**
	 * Parses the JSON file and builds the pockets.
	 * 
	 * @param path        The path to the JSON file.
	 * @param gameManager The game manager.
	 */
	public void parse(String path, GameManager gameManager) {
		JSONParser parser = new JSONParser();
		ArrayList<Pocket> pockets = new ArrayList<Pocket>();
        Table table = gameManager.getTable();

		try {
			Object object = parser.parse(new FileReader(path));
            
			// convert Object to JSONObject
			JSONObject jsonObject = (JSONObject) object;

			// reading the "Pockets" section:
			JSONObject jsonTableObject = (JSONObject) jsonObject.get("Table");
            JSONArray jsonPockets      = (JSONArray) jsonTableObject.get("pockets");

			// reading from the array:
			for (Object obj : jsonPockets) {
				JSONObject jsonPock = (JSONObject) obj;

				// the pocket radius
				Double radius = (Double) jsonPock.get("radius");

				// the pocket position x and y
				Double positionX = (Double) ((JSONObject) jsonPock.get("position")).get("x");
				Double positionY = (Double) ((JSONObject) jsonPock.get("position")).get("y");


				// Builder code
				PocketBuilder builder = new PoolPocketBuilder();
				PocketDirector director = new PocketDirector(builder);
            	pockets.add(director.build(positionX, positionY, radius));
			}
            table.setPockets(pockets);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}