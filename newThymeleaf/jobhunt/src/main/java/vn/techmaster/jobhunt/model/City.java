package vn.techmaster.jobhunt.model;

public enum City {
    HaNoi("Hà nội"),
    HoChiMinh("Hồ Chí Minh"),
    HaiPhong("Hải phòng"),
    DaNang("Đà Nẵng");
  
    public String label;
    private City(String label) {
      this.label = label;
    }
  }
