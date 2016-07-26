package com.nabula.model

import javax.persistence.Id
import javax.persistence.MappedSuperclass

/**
 * Created by harihar on 15/07/16.
 */
@MappedSuperclass
open abstract class BaseDataEntity {
    @Id
    protected var code: String = ""
    protected var description: String = ""
}