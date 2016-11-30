package com.kmehohsoft.dev.serverside;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ERIDataBase {

    private Connection connection;
    private Statement selectStmt;

    public ERIDataBase(String server,String database,String user,String password){
        selectStmt = null;
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://" + server + ";databaseName=" + database + ";user=" + user + ";password=" + password);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resetActivationCodeData(int idforuser){
        Statement updateStmt = null;

        try{
            updateStmt = connection.createStatement();
            updateStmt.execute("update [eri40-dev].[dbo].[LoginActivations] set [IsActivated]=0 where [Id]=" + Integer.toString(idforuser));
            updateStmt.execute("update [eri40-dev].[dbo].[LoginActivations] set [OperationDate]=NULL where [Id]=" + Integer.toString(idforuser));
        }
        catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                updateStmt.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getUserActivationCode(int userid){
        String activationCode = null;
        try
        {
            selectStmt = connection.createStatement();
            ResultSet rs = selectStmt.executeQuery("select [ActivationCode] from [eri40-dev].[dbo].[LoginActivations] where [IsActivated]=0 and [Id]=" + Integer.toString(userid));
            while(rs.next()){
                activationCode = rs.getString(1);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                selectStmt.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        return activationCode;
    }

    public String getUserLoginName(int userid){
        String loginName = null;
        try
        {
            selectStmt = connection.createStatement();
            ResultSet rs = selectStmt.executeQuery("select [LoginName] from [eri40-dev].[dbo].[Logins] where [Id]=" + Integer.toString(userid));
            while(rs.next()){
                loginName = rs.getString(1);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                selectStmt.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        return loginName;
    }

    public String getUserDomainName(int userid){
        String domainName = null;
        try
        {
            selectStmt = connection.createStatement();
            ResultSet rs = selectStmt.executeQuery("select [Name] from [eri40-dev].[dbo].[Domains] dm join [eri40-dev].[dbo].[Logins] lg on lg.[Domain_Id]=dm.[Id] where lg.[Id]=" + Integer.toString(userid));
            while(rs.next()){
                domainName = rs.getString(1);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                selectStmt.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        return domainName;
    }

    public List<String> getListOFUserPatients(int userid){
        List<String> listofpatientsnames = new ArrayList<String>();

        try
        {
            selectStmt = connection.createStatement();
            ResultSet rs = selectStmt.executeQuery("select [Surname],[Name] from [eri40-dev].[dbo].[Patients] where [IsDeleted]=0 and [AgreeWithPublication]=1 and [User_Id]=" + Integer.toString(userid));
            while(rs.next()){
                listofpatientsnames.add(rs.getString(1) + " " + rs.getString(2));
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                selectStmt.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        for(String s: listofpatientsnames){
            System.out.println(s);
        }

        return listofpatientsnames;
    }

    public boolean checkIfUserHasPatients(int userid){
        String numberofpatients = "";
        try
        {
            selectStmt = connection.createStatement();
            ResultSet rs = selectStmt.executeQuery("select count([Id]) from [eri40-dev].[dbo].[Patients] where [IsDeleted]=0 and [AgreeWithPublication]=1 and [User_Id]=" + Integer.toString(userid));
            while(rs.next()){
                numberofpatients = rs.getString(1);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                selectStmt.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (Integer.parseInt(numberofpatients) > 0) return true;

        return false;
    }

    private String getFirstUserPatientID(int userid,String username){
        String patientid = "";
        String delim = "[ ]+";
        String[] partsofpatientname = username.split(delim);
        try
        {
            selectStmt = connection.createStatement();
            ResultSet rs = selectStmt.executeQuery("select [Id] from [eri40-dev].[dbo].[Patients] where [Surname] like '" + partsofpatientname[0] + "' and [Name] like '" + partsofpatientname[1] + "' and [User_Id]=" + Integer.toString(userid));
            while(rs.next()){
                patientid = rs.getString(1);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                selectStmt.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        return patientid;
    }

    public int getFirstPatientVisitsNumber(int userid,String username){
        String patientvisitsnumber = "";
        try
        {
            selectStmt = connection.createStatement();
            ResultSet rs = selectStmt.executeQuery("select count([Id]) from [eri40-dev].[dbo].[Visits] where [Patient_Id]='" + getFirstUserPatientID(userid,username) + "'");
            while(rs.next()){
                patientvisitsnumber = rs.getString(1);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                selectStmt.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        return Integer.parseInt(patientvisitsnumber);

    }

    public String getFirstPatientLastVisitDate(int userid,String username){
        String patientlastvisitdate = "";
        String delim = "[ ]+";
        DateFormat oldFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat newFormat = new SimpleDateFormat("dd.MM.yyyy");
        try
        {
            selectStmt = connection.createStatement();
            ResultSet rs = selectStmt.executeQuery("select max([Date]) from [eri40-dev].[dbo].[Visits] where [Patient_Id]='" + getFirstUserPatientID(userid, username) + "'");
            while(rs.next()){
                patientlastvisitdate = rs.getString(1).split(delim)[0];

            }

            patientlastvisitdate = newFormat.format(oldFormat.parse(patientlastvisitdate));
        }
        catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                selectStmt.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        return patientlastvisitdate;
    }

    protected void finalize(){
        if (connection != null){
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
