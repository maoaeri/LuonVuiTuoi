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
    public static final int THU = 1,CHI = 0;
    private int categoryType;
    private int categoryId;
    private String categoryName;
    private int categoryParentId;

    public CategoryDTO() {
    }

    public CategoryDTO(int categoryType, int categoryId, String categoryName, int categoryParentId) {
        this.categoryType = categoryType;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryParentId = categoryParentId;
    }

    public CategoryDTO(int categoryType, int categoryId, String categoryName) {
        this.categoryType = categoryType;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
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

    public int getCategoryId() {
        return categoryId;
    }

    public int getCategoryParentId() {
        return categoryParentId;
    }

    public void setCategoryParentId(int categoryParentId) {
        this.categoryParentId = categoryParentId;
    }

    public void setCategoryType(int categoryType) {
        this.categoryType = categoryType;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    
    public boolean isIncome(){
        if (this.categoryType == THU){
            return true;
        } else {
            return false;
        }
    }
}
