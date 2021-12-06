package com.example.sickreads;

import javax.sql.rowset.serial.SerialBlob;
import java.util.Date;

public class Books {
    int id;
    String title;
    String authorName;
    Date datePublished;
    String description;
    String redirectUrl;
    SerialBlob cover;
}
