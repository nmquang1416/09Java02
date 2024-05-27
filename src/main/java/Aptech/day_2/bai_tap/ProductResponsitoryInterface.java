package Aptech.day_2.bai_tap;

import java.util.ArrayList;

public interface ProductResponsitoryInterface {
//    lay ve danh sach san pham trong database
    ArrayList<Product> findAll();
//    tim kiem bằng Id
    Product findById(long id);
//    luu thong tin product vao database, tro ve doi tuong product de luu thong tin theo id
    Product save(Product product);
//    xoa du lieu theo id truyen vao
    void deleteById(long id);
}
