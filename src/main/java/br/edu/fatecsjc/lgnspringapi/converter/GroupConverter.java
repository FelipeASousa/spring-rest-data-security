package br.edu.fatecsjc.lgnspringapi.converter;

import br.edu.fatecsjc.lgnspringapi.dto.GroupDTO;
import br.edu.fatecsjc.lgnspringapi.entity.Group;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupConverter implements Converter<Group, GroupDTO> {
    @Autowired
    private ModelMapper modelMapper;

    private TypeMap<GroupDTO, Group> propertyMapperDto;

    @Override
    public Group convertToEntity(GroupDTO dto) {
        if(propertyMapperDto == null) {
            propertyMapperDto = modelMapper.createTypeMap(GroupDTO.class, Group.class);
            propertyMapperDto.addMappings(mapper -> mapper.skip(Group::setId));
        }

        Group entity = modelMapper.map(dto, Group.class);
        Provider<Group> groupProvider = p -> new Group();
        propertyMapperDto.setProvider(groupProvider);

        entity.getMembers().forEach(m -> {
            m.setGroup(entity);
        });
        return entity;
    }

    @Override
    public Group convertToEntity(GroupDTO dto, Group entity) {
        if(propertyMapperDto == null) {
            propertyMapperDto = modelMapper.createTypeMap(GroupDTO.class, Group.class);
            propertyMapperDto.addMappings(mapper -> mapper.skip(Group::setId));
        }

        Provider<Group> groupProvider = p -> entity;
        propertyMapperDto.setProvider(groupProvider);

        Group newEntity = modelMapper.map(dto, Group.class);
        newEntity.getMembers().forEach(member -> {
            member.setGroup(newEntity);
        });
        return newEntity;
    }

    @Override
    public GroupDTO convertToDto(Group entity) {
        return modelMapper.map(entity, GroupDTO.class);
    }

    @Override
    public List<Group> convertToEntity(List<GroupDTO> dtos) {
        List<Group> groups = modelMapper.map(dtos, new TypeToken<List<Group>>(){}.getType());
        groups.forEach(group -> {
            group.getMembers().forEach(member -> {
                member.setGroup(group);
            });
        });
        return groups;
    }

    @Override
    public List<GroupDTO> convertToDto(List<Group> entities) {
        return modelMapper.map(entities, new TypeToken<List<GroupDTO>>(){}.getType());
    }
}
