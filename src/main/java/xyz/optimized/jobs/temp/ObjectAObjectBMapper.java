package xyz.optimized.jobs.temp;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ObjectAObjectBMapper {
    ObjectAObjectBMapper INSTANCE = Mappers.getMapper(ObjectAObjectBMapper.class);

    @Mapping( target = "name", source = "nameObjectB")
    ObjectA toObjectA(ObjectB objectB);

    @Mapping( target = "nameObjectB", source = "name")
    ObjectB toObjectB(ObjectA objectA);
}
