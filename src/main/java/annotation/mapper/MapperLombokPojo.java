package annotation.mapper;

import annotation.LombokDataPojo;
import annotation.LombokPojo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapperLombokPojo {

    MapperLombokPojo MAPPER = Mappers.getMapper(MapperLombokPojo.class);

    LombokPojo toPojo(LombokDataPojo data);

    LombokDataPojo toData(LombokPojo pojo);
}


