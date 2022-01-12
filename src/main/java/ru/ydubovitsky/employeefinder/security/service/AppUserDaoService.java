package ru.ydubovitsky.employeefinder.security.service;

import ru.ydubovitsky.employeefinder.security.model.AppUser;

public interface AppUserDaoService {

    AppUser getAppUserByUsername(String username);

}
