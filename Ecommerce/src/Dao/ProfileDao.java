package Dao;

import java.util.List;

import Pojo.ProfilePojo;

public interface ProfileDao {
public boolean addProfile(ProfilePojo profilePojo);
public List<ProfilePojo> showProfile(String email);
}
