/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.javaiodemo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yurii
 */
public class Person implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public String fio;
    public List<BigDecimal> balances = new ArrayList<>();
}
