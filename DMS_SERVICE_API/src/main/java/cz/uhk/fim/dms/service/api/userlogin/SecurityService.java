package cz.uhk.fim.dms.service.api.userlogin;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
