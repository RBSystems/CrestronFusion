////
//
// File:    ApiLog.java
// Purpose: Used to create and write to the log file
// Created: 09 May 2012
//
// Copyright 2012 Crestron Electronics, Inc.
// 
////

package com.ztfd.crestronFusion.servlet;

import com.ztfd.crestronFusion.helpers.API_Constants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ApiLog {
    
    public static ApiLog One = new ApiLog();
    String logFile = API_Constants.LogFilePath + API_Constants.LogFileName;

    private ApiLog()
    {
    }
    
    /**
     * Initializes APILog, creates single instance
     */
    private void Initialize()
    {
        try
        {
        if(One == null)
            One = new ApiLog();
        // Create file 
        File file = new File(logFile);
        if(!file.exists())
            file.createNewFile();
        }
        catch(Exception ex)
        {}
    }

    /**
     * Writes text to log file
     * @param textToLog - Text to write to log file
     */
    public void WriteText(String textToLog)
    {
        Initialize();
        try
        {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date date = new Date();
            textToLog = dateFormat.format(date) + "--" + textToLog;
            FileWriter fstream = new FileWriter(logFile, true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(textToLog);
            out.newLine();
            //Close the output stream
            out.close();
        }
        catch (Exception e){
        }
    }
    
    /**
     * Writes exception message and stacktrace to log file
     * @param ex  - Exception
     */
     public void WriteException(Exception ex)
    {
        WriteText("Exception:: Message:" + ex.getMessage() + " StackTrace: " + Arrays.toString(ex.getStackTrace()));
    }
}
