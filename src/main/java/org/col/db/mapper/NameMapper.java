package org.col.db.mapper;

import org.apache.ibatis.annotations.*;
import org.col.api.Name;

/**
 *
 */
public interface NameMapper {
    String COLS = "scientific_name, canonical_name, authorship, monomial, epithet, infra_epithet, rank, notho, parsed, published_in_key, published_in_year";
    String PROPS = "#{scientificName}, #{canonicalName}, #{authorship}, #{monomial}, #{epithet}, #{infraEpithet}, #{rank}, #{notho}, #{parsed}, #{publishedInKey}, #{publishedInYear}";

    @Select("SELECT * FROM name WHERE key = #{key}")
    Name get(int key);

    @Insert("INSERT INTO name ("+COLS+") VALUES ("+PROPS+")")
    @Options(useGeneratedKeys=true, keyProperty="key")
    void insert(Name name);

    @Update("UPDATE name SET ("+COLS+") = ("+PROPS+") WHERE key = #{key}")
    void update(Name name);

    @Delete("DELETE FROM name WHERE key = #{key}")
    void delete(int key);
}

