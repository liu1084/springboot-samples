package com.example.javaserializesamples;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Author: Jim
 * Date: 2018/8/23:下午4:06
 * Description:
 */

@Setter
@Getter
public class Male extends Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private transient Weapon weapons; //Weapon未实现序列化，可以在writeObject进行自定义序列化，通过readObject反序列化

    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();
        outputStream.writeObject(weapons.getName());
    }

    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();
        String weaponName = (String) inputStream.readObject();
        Weapon weapon = new Weapon();
        weapon.setName(weaponName);
        this.setWeapons(weapon);
    }
}
