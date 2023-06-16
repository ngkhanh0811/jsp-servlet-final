package com.example.jpa_sem4.utils;/*Welcome to my show !

@author: NgKhanh
Date: 6/14/2023
Time: 7:29 PM

ProjectName: jpa_sem4*/

public class OrderClauseBuilder {

    private StringBuilder whereClause;

    public OrderClauseBuilder() {
        super();

        this.whereClause = new StringBuilder();
    }

    public void add(String columnName, boolean desc) {
        // todo if columnName -> throw ex
        if (columnName == null){
            throw new RuntimeException();
        }

        if (!isEmpty()) {
            this.whereClause.append(", ");
        }

        this.whereClause.append(columnName);

        if (desc) {
            this.whereClause.append(" DESC");
        }
    }

    public boolean isEmpty() {
        return this.whereClause.toString().isEmpty();
    }

    public String getClause() {
        return this.whereClause.toString();
    }

}
