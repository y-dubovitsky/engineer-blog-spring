package ru.ydubovitsky.engineerblog.security.service;

import ru.ydubovitsky.engineerblog.security.model.AppUser;

public interface AppUserDaoService {

    AppUser getAppUserByUsername(String username);

}
