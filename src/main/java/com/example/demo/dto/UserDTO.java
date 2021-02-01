package com.example.demo.dto;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.dto
 * @ClassName: UserDTO
 * @Description: java类作用描述
 * @Author: 李佳阳
 * @CreateDate: 2020/3/10 18:19
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/10 18:19
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class UserDTO {
    private int userId;
    private int roleId;
    private String phone;
    private String nickName;
    private String realName;
    private String identityNumber;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }
}
