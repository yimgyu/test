package com.example.mybatis_test3.Entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser_info_Entity is a Querydsl query type for User_info_Entity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser_info_Entity extends EntityPathBase<User_info_Entity> {

    private static final long serialVersionUID = -850541759L;

    public static final QUser_info_Entity user_info_Entity = new QUser_info_Entity("user_info_Entity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath user_id = createString("user_id");

    public final StringPath user_name = createString("user_name");

    public final StringPath user_name_uuid = createString("user_name_uuid");

    public final StringPath user_pw = createString("user_pw");

    public QUser_info_Entity(String variable) {
        super(User_info_Entity.class, forVariable(variable));
    }

    public QUser_info_Entity(Path<? extends User_info_Entity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser_info_Entity(PathMetadata metadata) {
        super(User_info_Entity.class, metadata);
    }

}

