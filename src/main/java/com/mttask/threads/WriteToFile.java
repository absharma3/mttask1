package com.mttask.threads;

import com.mttask.model.BookDetails;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by abhimanyus on 2/1/18.
 */
public class WriteToFile implements Callable<String>{


    private final String fileName;
    private List<BookDetails> listOfBooks;

    public WriteToFile(String fileName, List<BookDetails> listOfBooks) {
        this.listOfBooks = listOfBooks;
        this.fileName =  fileName;
    }

    public String call() {
        StringBuilder builder = new StringBuilder();
        for (BookDetails book: listOfBooks) {
            builder.append(book.toString() + "\n");
        }

        try {
            FileUtils.write(new File(fileName), builder.toString(), "UTF-16");
        } catch (IOException e) {
            return "Unable to process";
        }
        return "Sucessful processing of file" + this.fileName;
    }
}
