package com.spring.pojo;


public class Systemlogmessage {

  private long idSystemLogMessage;
  private String systemLogMessage_Name;
  private String systemLogMessage_Roles;
  private String systemLogMessag_Method;
  private String systemLogMessage_Description;
  private String systemLogMessage_Params;
  private java.sql.Date systemLogMessage_StartTime;
  private String systemLogMessage_Time;
  private String systemLogMessage_Successful;
  private String systemLogMessage_Exception;

  @Override
  public String toString() {
    return "Systemlogmessage{" +
            "idSystemLogMessage=" + idSystemLogMessage +
            ", systemLogMessage_Name='" + systemLogMessage_Name + '\'' +
            ", systemLogMessage_Roles='" + systemLogMessage_Roles + '\'' +
            ", systemLogMessag_Method='" + systemLogMessag_Method + '\'' +
            ", systemLogMessage_Description='" + systemLogMessage_Description + '\'' +
            ", systemLogMessage_Params='" + systemLogMessage_Params + '\'' +
            ", systemLogMessage_StartTime=" + systemLogMessage_StartTime +
            ", systemLogMessage_Time='" + systemLogMessage_Time + '\'' +
            ", systemLogMessage_Successful='" + systemLogMessage_Successful + '\'' +
            ", systemLogMessage_Exception='" + systemLogMessage_Exception + '\'' +
            '}';
  }

  public long getIdSystemLogMessage() {
    return idSystemLogMessage;
  }

  public void setIdSystemLogMessage(long idSystemLogMessage) {
    this.idSystemLogMessage = idSystemLogMessage;
  }


  public String getSystemLogMessage_Name() {
    return systemLogMessage_Name;
  }

  public void setSystemLogMessage_Name(String systemLogMessage_Name) {
    this.systemLogMessage_Name = systemLogMessage_Name;
  }


  public String getSystemLogMessage_Roles() {
    return systemLogMessage_Roles;
  }

  public void setSystemLogMessage_Roles(String systemLogMessage_Roles) {
    this.systemLogMessage_Roles = systemLogMessage_Roles;
  }


  public String getSystemLogMessag_Method() {
    return systemLogMessag_Method;
  }

  public void setSystemLogMessag_Method(String systemLogMessag_Method) {
    this.systemLogMessag_Method = systemLogMessag_Method;
  }


  public String getSystemLogMessage_Description() {
    return systemLogMessage_Description;
  }

  public void setSystemLogMessage_Description(String systemLogMessage_Description) {
    this.systemLogMessage_Description = systemLogMessage_Description;
  }


  public String getSystemLogMessage_Params() {
    return systemLogMessage_Params;
  }

  public void setSystemLogMessage_Params(String systemLogMessage_Params) {
    this.systemLogMessage_Params = systemLogMessage_Params;
  }


  public java.sql.Date getSystemLogMessage_StartTime() {
    return systemLogMessage_StartTime;
  }

  public void setSystemLogMessage_StartTime(java.sql.Date systemLogMessage_StartTime) {
    this.systemLogMessage_StartTime = systemLogMessage_StartTime;
  }


  public String getSystemLogMessage_Time() {
    return systemLogMessage_Time;
  }

  public void setSystemLogMessage_Time(String systemLogMessage_Time) {
    this.systemLogMessage_Time = systemLogMessage_Time;
  }


  public String getSystemLogMessage_Successful() {
    return systemLogMessage_Successful;
  }

  public void setSystemLogMessage_Successful(String systemLogMessage_Successful) {
    this.systemLogMessage_Successful = systemLogMessage_Successful;
  }


  public String getSystemLogMessage_Exception() {
    return systemLogMessage_Exception;
  }

  public void setSystemLogMessage_Exception(String systemLogMessage_Exception) {
    this.systemLogMessage_Exception = systemLogMessage_Exception;
  }

}
