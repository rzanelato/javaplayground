package annotation.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import annotation.*;

import java.util.Collections;
import org.junit.jupiter.api.Test;

class MapperLombokDataTest {

    @Test
    void shouldReturnFullDtoWhen_toDto_HasAllValues() {
        LombokBuilder lombok = LombokBuilder.builder().description("Desc").builds();
        LombokDataPojo dataPojo = new LombokDataPojo("New", "Old", lombok);
        LombokData data = new LombokData("Test", "email@email.com", Collections.singletonList(dataPojo));

        LombokDTO dto = MapperLombokData.MAPPER.toDto(data);

        assertNotNull(dto);
        assertEquals("Test", dto.getName());
        assertEquals("email@email.com", dto.getEmail());
        assertNotNull(dto.getPojos());
        assertEquals(1, dto.getPojos().size());
        assertEquals("New", dto.getPojos().get(0).getKey());
        assertEquals("Old", dto.getPojos().get(0).getValue());
        assertNotNull(dto.getPojos().get(0).getLombok());
        assertEquals("Desc", dto.getPojos().get(0).getLombok().getDescription());
    }

    @Test
    void shouldReturnDtoEmptyListWhen_toDto_HasEmptyList() {
        LombokData data = new LombokData("Test", "email@email.com", Collections.emptyList());

        LombokDTO dto = MapperLombokData.MAPPER.toDto(data);

        assertNotNull(dto);
        assertEquals("Test", dto.getName());
        assertEquals("email@email.com", dto.getEmail());
        assertNotNull(dto.getPojos());
        assertTrue(dto.getPojos().isEmpty());
    }

    @Test
    void shouldReturnDtoWithoutListWhen_toDto_HasNullList() {
        LombokData data = new LombokData("Test", "email@email.com", null);

        LombokDTO dto = MapperLombokData.MAPPER.toDto(data);

        assertNotNull(dto);
        assertEquals("Test", dto.getName());
        assertEquals("email@email.com", dto.getEmail());
        assertNull(dto.getPojos());
    }

    @Test
    void shouldReturnNullDtoWhen_toDto_HasNullData() {
        LombokDTO dto = MapperLombokData.MAPPER.toDto(null);

        assertNull(dto);
    }

    @Test
    void shouldReturnFullDataWhen_toDto_HasAllValues() {
        LombokPojo pojo = new LombokPojo("New", "Old", null);
        LombokDTO dto = new LombokDTO("Test", "email@email.com", Collections.singletonList(pojo));

        LombokData data = MapperLombokData.MAPPER.toData(dto);

        assertNotNull(data);
        assertEquals("Test", data.getName());
        assertEquals("email@email.com", data.getEmail());
        assertNotNull(data.getPojos());
        assertEquals(1, data.getPojos().size());
        assertEquals("New", data.getPojos().get(0).getKey());
        assertEquals("Old", data.getPojos().get(0).getValue());
        assertNull(data.getPojos().get(0).getLombok());
    }

    @Test
    void shouldReturnDataWithoutListWhen_toDto_HasNullList() {
        LombokDTO dto = new LombokDTO("Test", "email@email.com", null);

        LombokData data = MapperLombokData.MAPPER.toData(dto);

        assertNotNull(data);
        assertEquals("Test", data.getName());
        assertEquals("email@email.com", data.getEmail());
        assertNull(data.getPojos());
    }

    @Test
    void shouldReturnDataEmptyListWhen_toDto_HasEmptyList() {
        LombokDTO dto = new LombokDTO("Test", "email@email.com", Collections.emptyList());

        LombokData data = MapperLombokData.MAPPER.toData(dto);

        assertNotNull(data);
        assertEquals("Test", data.getName());
        assertEquals("email@email.com", data.getEmail());
        assertNotNull(data.getPojos());
        assertTrue(data.getPojos().isEmpty());
    }

    @Test
    void shouldReturnNullDataWhen_toDto_HasNullDto() {
        LombokData data = MapperLombokData.MAPPER.toData(null);

        assertNull(data);
    }

}
