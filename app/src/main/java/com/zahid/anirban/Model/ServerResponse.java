package com.zahid.anirban.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Zahid on 05-Jun-17.
 */



    public class ServerResponse  {




    @SerializedName("OrgCode") String orgcode;
    @SerializedName("OrgName") String orgname;
    @SerializedName("BranchCode") String branchcode;
    @SerializedName("BranchName") String branchname;
    @SerializedName("FieldOfficerCode") String fieldOfficercode;
    @SerializedName("FieldOfficerName") String fieldOfficername;
    @SerializedName("UserName") String username;
    @SerializedName("FirstName") String firstname;
    @SerializedName("Password") String password;
    @SerializedName("LastName") String lastname;
    @SerializedName("Role") String role;
    @SerializedName("ermittedModules") String ermittedmodules;
    @SerializedName("Phone") String Phone;
    @SerializedName("ogInPermissionFlag") String ogInPermissionFlag;
    @SerializedName("Message") String Message;
    @SerializedName("NewAppsVersion") String NewAppsVersion;
    @SerializedName("AppsDownloadLink") String AppsDownloadLink;
    @SerializedName("Id") String Id;
    @SerializedName("UserId") String UserId;
    @SerializedName("MakeDate") String MakeDate;
    @SerializedName("UpdateUserId") String UpdateUserId;
    @SerializedName("UpdtDate") String UpdtDate;
    @SerializedName("UpddtDate") String UpddtDate;
    @SerializedName("CreatedBy") String CreatedBy;
    @SerializedName("CreatedDate") String CreatedDate;
    @SerializedName("UpdatedBy") String UpdatedBy;
    @SerializedName("pdatedDate") String pdatedDate;
    @SerializedName("DeletedBy") String DeletedBy;
    @SerializedName("DeletedDate") String DeletedDate;
    @SerializedName("Edit") String Edit;
    @SerializedName("Delete") String Delete;
    @SerializedName("View") String View;
    @SerializedName("Time") String Time;
    @SerializedName("Command") String Command;


    public String getOrgcode() {
        return orgcode;
    }


    }














