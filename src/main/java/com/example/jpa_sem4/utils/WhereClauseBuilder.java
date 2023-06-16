package com.example.jpa_sem4.utils;/*Welcome to my show !

@author: NgKhanh
Date: 6/14/2023
Time: 7:18 PM

ProjectName: jpa_sem4*/

import com.example.jpa_sem4.constant.SqlStatementEnum;

public class WhereClauseBuilder {
    private StringBuilder whereClause;
    public void andClause(String clause){
        // todo: add and clause in where
        if (!isEmpty()){
            this.whereClause.append(SqlStatementEnum.SPACE.value).append(SqlStatementEnum.AND.value).append(SqlStatementEnum.SPACE.value);
        }
        this.whereClause.append(clause);
    }

    public void orClause(String clause){
        // todo: add and clause in where
        if (!isEmpty()){
            this.whereClause.append(SqlStatementEnum.SPACE.value).append(SqlStatementEnum.OR.value).append(SqlStatementEnum.SPACE.value);
        }
        this.whereClause.append(clause);
    }

    public boolean isEmpty(){
        return this.whereClause.toString().isEmpty();
    };

    public String getClause(){
        return this.whereClause.toString();
    }

    public WhereClauseBuilder() {
        this.whereClause = new StringBuilder();
    }
}
