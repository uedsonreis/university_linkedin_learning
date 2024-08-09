package com.example.university.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPerson is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QPerson extends BeanPath<Person> {

    private static final long serialVersionUID = 943477584L;

    public static final QPerson person = new QPerson("person");

    public final StringPath firstName = createString("firstName");

    public final StringPath lastName = createString("lastName");

    public QPerson(String variable) {
        super(Person.class, forVariable(variable));
    }

    public QPerson(Path<? extends Person> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPerson(PathMetadata metadata) {
        super(Person.class, metadata);
    }

}

