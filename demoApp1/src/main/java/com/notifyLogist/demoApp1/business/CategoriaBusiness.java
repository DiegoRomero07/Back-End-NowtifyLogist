package com.notifyLogist.demoApp1.business;

import com.notifyLogist.demoApp1.dtos.CategoriaDto;
import com.notifyLogist.demoApp1.entity.CategoriaEntity;
import com.notifyLogist.demoApp1.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoriaBusiness {

    @Autowired
    private CategoriaService categoriaService;
    private List<CategoriaEntity> categoriaEntityList;
    private final List<CategoriaDto> categoriaDtoList = new ArrayList<>();

    public List<CategoriaDto> getAll(){
        this.categoriaEntityList = this.categoriaService.getAll();
        this.categoriaEntityList.stream().forEach(categoria -> {
            CategoriaDto categoriaDto = new CategoriaDto();
            categoriaDto.setIdCategoria(categoria.getIdCategoria());
            categoriaDto.setNombreCategoria(categoria.getNombreCategoria());
            categoriaDto.setDescripcion(categoria.getDescripcion());

            categoriaDtoList.add(categoriaDto);
        });
        return categoriaDtoList;
    }

    public CategoriaEntity findById(Integer idCategoria) {
        return this.categoriaService.findById(idCategoria);
    }

    public void createCategoria(CategoriaDto categoriaDto) throws Exception{
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setNombreCategoria(categoriaDto.getNombreCategoria());
        categoriaEntity.setDescripcion(categoriaDto.getDescripcion());

        this.categoriaService.create(categoriaEntity);
    }

    public void updateCategoria(Integer id, CategoriaDto updateCategoriaDto) throws Exception{
        CategoriaEntity existeCategoriaEntity = categoriaService.findById(id);
        if (existeCategoriaEntity == null){
            throw new Exception("CategoriaEntity no encontrada");
        }
        existeCategoriaEntity.setNombreCategoria(updateCategoriaDto.getNombreCategoria());
        existeCategoriaEntity.setDescripcion(updateCategoriaDto.getDescripcion());
        this.categoriaService.create(existeCategoriaEntity);
    }

    public void deleteCategoria(Integer id) throws Exception{
        CategoriaEntity existeCategoriaEntity = categoriaService.findById(id);
        if (existeCategoriaEntity == null){
            throw new Exception("CategoriaEntity no encontrada");
        }
        this.categoriaService.delete(existeCategoriaEntity);
    }
}
