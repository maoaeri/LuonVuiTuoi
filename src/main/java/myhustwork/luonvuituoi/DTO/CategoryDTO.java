/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myhustwork.luonvuituoi.DTO;

/**
 *
 * @author vvlalalove193
 */
public class CategoryDTO {
    static final int THU = 1,CHI = 0;
    int categoryType;
    String categoryName;

    public CategoryDTO() {
    }

    public CategoryDTO(int categoryType, String categoryName) {
        this.categoryType = categoryType;
        this.categoryName = categoryName;
    }
    

    public int getCategoryType() {
        return categoryType;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryType(int categoryType) {
        this.categoryType = categoryType;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    
}
