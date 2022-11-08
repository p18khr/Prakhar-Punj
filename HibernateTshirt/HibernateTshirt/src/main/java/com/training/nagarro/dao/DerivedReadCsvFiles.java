package com.training.nagarro.dao;

import com.training.nagarro.models.DerivedTshirt;
import com.opencsv.CSVReader;

import java.io.File;
import java.util.StringTokenizer;
import java.io.FileReader;
import java.util.ArrayList;

public class DerivedReadCsvFiles implements ReadCsvFiles{
    public DerivedIODataBase db = new DerivedIODataBase();


    @Override          // retrieves and stores data as Tshirt object
    public void storeCsvData(){
        File all = new File("src/main/resources/csv");

        String[] fileName = all.list();


        for(int i=0;i<fileName.length;i++){
            try{

                FileReader filereader = new FileReader("src/main/resources/csv/"+fileName[i]);
                CSVReader reader = new CSVReader(filereader);

                String[] nextRecord;

                boolean firstLine = true;

                while ((nextRecord = reader.readNext()) != null) {

                    if(firstLine == true){
                        firstLine = false;
                        continue;
                    }

                    StringTokenizer strT = new StringTokenizer(nextRecord[0],"|");
                    ArrayList<String> al = new ArrayList<>();
                    DerivedTshirt t = new DerivedTshirt();
                    while (strT.hasMoreTokens()) {
                        al.add(strT.nextToken());
                    }
                    t.setId(al.get(0));
                    t.setName(al.get(1));
                    t.setColour(al.get(2));
                    t.setGender(al.get(3));
                    t.setSize(al.get(4));
                    t.setPrice(Double.valueOf(al.get(5)));
                    t.setRating(Float.valueOf(al.get(6)));
                    t.setAvailability(al.get(7));
                    db.insertIntoDatabase(t);
                }
            }

            catch(Throwable e){
                System.out.println(e+" Error @ Storecsvdata");
            }
        }

    }

}
