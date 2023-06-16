package com.example.jpa_sem4.impl;/*Welcome to my show !

@author: NgKhanh
Date: 6/14/2023
Time: 7:10 PM

ProjectName: jpa_sem4*/

import com.example.jpa_sem4.JpaExecutors;
import com.example.jpa_sem4.annotation.Column;
import com.example.jpa_sem4.annotation.Entity;
import com.example.jpa_sem4.annotation.Id;
import com.example.jpa_sem4.config.DBConnection;
import com.example.jpa_sem4.constant.SqlStatementEnum;
import com.example.jpa_sem4.entity.Product;
import com.example.jpa_sem4.utils.SelectQueryBuilder;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JpaExecutorImpl<T> implements JpaExecutors<T> {
    private Class<T> clazz;
    private String className;
    private String tableName;

    public JpaExecutorImpl(Class<T> clazz){
        this.clazz = clazz;
        this.className = clazz.getSimpleName();
        this.tableName = (clazz.getAnnotation(Entity.class) != null) ? clazz.getAnnotation(Entity.class).tablename() :
                this.className.toLowerCase();
    }

    public List<T> entityParser(ResultSet rs){
        List<T> entitys = new ArrayList<>();
        try {
            while(rs.next()){
                T entity = clazz.getDeclaredConstructor().newInstance();
                for(Field f : entity.getClass().getDeclaredFields()){
                    String columnName = f.getName();
                    if (f.isAnnotationPresent(Column.class) && !StringUtils.isEmpty(f.getAnnotation(Column.class).name())) {
                        Column columnInfo = f.getAnnotation(Column.class);
                        //todo: chưa lấy ra được id
                        columnName = columnInfo.name();
                        f.setAccessible(true);
                            switch (columnInfo.dataType()) {
                                case INTEGER:
                                    f.set(entity, rs.getInt(columnName));
                                    break;
                                case TEXT:
                                    f.set(entity, rs.getString(columnName));
                                    break;
                                case BIG_INTEGER:
                                    f.set(entity, rs.getInt(columnName));
                                    break;
                                case SMALL_INTEGER:
                                    f.set(entity, rs.getInt(columnName));
                                    break;
                                case DATE:
                                    f.set(entity, rs.getDate(columnName));
                                    break;
                                case FLOAT:
                                    f.set(entity, rs.getFloat(columnName));
                                    break;
                                case DOUBLE:
                                    f.set(entity, rs.getInt(columnName));
                                    break;
                                // todo : Làm tiếp tục với các kiểu dữ liệu còn lại
                                // fixme: Fix nốt đê
                        }
                    }
                    if (f.isAnnotationPresent(Id.class) && !StringUtils.isEmpty(f.getAnnotation(Id.class).name())){
                        Id id = f.getAnnotation(Id.class);
                        f.setAccessible(true);
                        f.set(entity, rs.getInt(id.name()));
                        System.err.println(entity);
                    }
                }
                entitys.add(entity);
            }
        }
        catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e){
            throw new RuntimeException();
        }

        return entitys;
    }
    public List<T> findall(){
        Connection conn = null;
        try {
            conn = DBConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(conn == null) {
            // todo: log
            System.err.println("Connection is null" + conn);
        } else {
            System.err.println(conn);
        }

        SelectQueryBuilder select = new SelectQueryBuilder(tableName);

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(select.getQuery());

            ResultSet rs = preparedStatement.executeQuery();
            //todo: serr query
            System.err.println(select.getQuery());
            return entityParser(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn!=null && !conn.isClosed()){
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public T getById(String id) {
        Connection conn = null;
        try {
            conn = DBConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(conn == null) {
            // todo: log
            System.err.println("Connection is null" + conn);
        } else {
            System.err.println(conn);
        }

        SelectQueryBuilder select = new SelectQueryBuilder(tableName);
        String idColumnName = null;
        for (Field f: clazz.getDeclaredFields()){
            if (f.isAnnotationPresent(Id.class)){
                idColumnName = f.getAnnotation(Id.class).name();
            }
        }
        select.andClause(idColumnName + " = " + id);
        System.err.println(select.getQuery());

        String query = select.getQuery();
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            //todo: thực hiện query và lấy ra dữ liệu theo id ở đây
            List<T> result = entityParser(resultSet);
//            System.out.println(result.get(0));
            if(!result.isEmpty()){
//                System.out.println(result.get(0));
                return result.get(0);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
