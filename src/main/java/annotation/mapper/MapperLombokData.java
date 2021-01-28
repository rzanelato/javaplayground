package annotation.mapper;

import annotation.LombokDTO;
import annotation.LombokData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapperLombokData {

    MapperLombokData MAPPER = Mappers.getMapper(MapperLombokData.class);
    LombokDTO toDto(LombokData data);
    LombokData toData(LombokDTO dto);
}


