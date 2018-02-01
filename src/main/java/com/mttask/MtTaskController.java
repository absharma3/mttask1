package com.mttask;

import com.mttask.helper.CSVHelper;
import com.mttask.model.BookDetails;
import com.mttask.threads.WriteToFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by abhimanyus on 2/1/18.
 */
public class MtTaskController {

    ExecutorService executor = Executors.newFixedThreadPool(10);
    static List<Future<String>> returnValList = new ArrayList<Future<String>>();
    volatile int fileCount =0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CSVHelper reader = new CSVHelper(10);
        try {
            reader.readAndExecute("/Users/abhimanyus/Desktop/Nonsense/OfficeTasks/MultiThreading1/Multithreading_Task1_Books.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Future<String> returnVal : returnValList){
            System.out.println(returnVal.get());
        }

    }


    public void spawnThreadsForWrite(List<BookDetails> listOfBooks) {
        fileCount ++;
        WriteToFile wtf = new WriteToFile("Books" +fileCount + ".txt",listOfBooks);
        Future<String> returnVals = executor.submit(wtf);
        returnValList.add(returnVals);

    }
}
