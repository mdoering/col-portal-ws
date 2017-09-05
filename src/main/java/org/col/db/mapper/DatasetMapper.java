package org.col.db.mapper;

import org.apache.ibatis.annotations.Param;
import org.col.api.Dataset;

public interface DatasetMapper {

  Dataset get(@Param("key") int key);

  void insert(@Param("d") Dataset dataset);

  void update(@Param("d") Dataset dataset);

  void delete(@Param("key") int key);

}
