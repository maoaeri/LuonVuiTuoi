package myhustwork.luonvuituoi.BLL;


import java.sql.SQLException;
import myhustwork.luonvuituoi.DAO.CategoryDAO;
import myhustwork.luonvuituoi.DTO.CategoryDTO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vvlalalove193
 */
public class CategoryBLL {
    private CategoryDAO catDAO;

    public CategoryBLL() {
        catDAO = new CategoryDAO();
    }
    
    public CategoryDTO[] getAll() throws SQLException{
        return catDAO.getAll();
    }
    
    public String[] getAllNames() throws SQLException{
        String[] names = new String[25];
        CategoryDTO[] catList = catDAO.getAll();
        for (int i = 0; i<=24; i++){
            names[i] = catList[i].getCategoryName();
        }
        return names;
    }
}
