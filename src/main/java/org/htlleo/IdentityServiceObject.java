package org.htlleo;

import java.rmi.RemoteException;
import java.util.UUID;

public class IdentityServiceObject implements IdentityService {
    public IdentityServiceObject() {

    }

    @Override
    public String createId() throws RemoteException {
        return UUID.randomUUID().toString();
    }
}
