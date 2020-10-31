package simulation.serializers;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import simulation.model.League;
import presentation.ConsoleOutput;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LeagueDataSerializerDeSerializer {
    public static final String FILENAME = "JsonOutput.txt";
    public static final String JSONCREATIONERROR = "Json could not be created";
    public static final String DESERIALIZATIONERROR = "Could not deserialize";
    public void serialize(League league) {
        if (league == null){
            return;
        }
        Gson gson = new GsonBuilder()
                .setPrettyPrinting().create();

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(FILENAME);
            gson.toJson(league, fileWriter);

        } catch (Exception e) {
            ConsoleOutput.printToConsole(JSONCREATIONERROR);
        }finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                ConsoleOutput.printToConsole(JSONCREATIONERROR);
            }

        }
    }

    public League deSerialize(){
        FileReader fileReader;
        JSONParser jsonParser = new JSONParser();
        League league = null;
        try{
            fileReader = new FileReader(FILENAME);
            Gson gson = new Gson();
            league = gson.fromJson(jsonParser.parse(fileReader).toString(),League.class);
            fileReader.close();
        } catch (FileNotFoundException e) {
            ConsoleOutput.printToConsole(DESERIALIZATIONERROR);
        } catch (ParseException e) {
            ConsoleOutput.printToConsole(DESERIALIZATIONERROR);
        } catch (IOException e) {
            ConsoleOutput.printToConsole(DESERIALIZATIONERROR);
        } catch (Exception e){
            ConsoleOutput.printToConsole(DESERIALIZATIONERROR);
        }
        return league;
    }

}