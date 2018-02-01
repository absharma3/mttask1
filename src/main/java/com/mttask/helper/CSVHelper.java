package com.mttask.helper;

import com.mttask.MtTaskController;
import com.mttask.model.BookDetails;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by abhimanyus on 2/1/18.
 */
public class CSVHelper {

    MtTaskController controller = new MtTaskController();
    int threshold = 0;

    public CSVHelper(int threshhold) {
        this.threshold = threshhold;
    }

    public List<BookDetails> readFile(String fileName) throws IOException {

        List<BookDetails> listOfBooks = new ArrayList<BookDetails>();

        LineIterator it = FileUtils.lineIterator(new File(fileName), "UTF-8");
        try {
            while (it.hasNext()) {
                String line = it.nextLine();
                String[] lineData = line.split(";");
                BookDetails book = new BookDetails(lineData[0], lineData[1],lineData[2], lineData[3],lineData[4],lineData[5],lineData[6],lineData[7] );
                // do something with line
                listOfBooks.add(book);
            }
        } finally {
            LineIterator.closeQuietly(it);
        }

        return listOfBooks;
    }

    public void readAndExecute(String filePath) throws IOException {

        int currentCounter = 0;
        List<BookDetails> listOfBooks = new ArrayList<BookDetails>();

        LineIterator it = FileUtils.lineIterator(new File(filePath), "UTF-8");
        try {
            while (it.hasNext()) {
                String line = it.nextLine();
                String[] lineData = line.split(";");
                BookDetails book = new BookDetails(lineData[0], lineData[1],lineData[2], lineData[3],lineData[4],lineData[5],lineData[6],lineData[7] );
                // do something with line
                if(currentCounter == threshold){
                    //spawn thread
                    //reset current counter
                    //reset list of books
                    controller.spawnThreadsForWrite(listOfBooks);
                    currentCounter = 0;
                    listOfBooks = new ArrayList<BookDetails>();

                }else {
                    listOfBooks.add(book);
                    currentCounter ++;
                }
            }
        } finally {
            LineIterator.closeQuietly(it);
        }

    }


}
