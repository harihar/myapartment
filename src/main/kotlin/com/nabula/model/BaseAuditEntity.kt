package com.nabula.model

import java.time.LocalDateTime
import javax.persistence.MappedSuperclass

/**
 * Created by harihar on 15/07/16.
 */
@MappedSuperclass
abstract open class BaseAuditEntity {
    var createdBy: Long = 0
    var createdDate: LocalDateTime = LocalDateTime.now()
    var modifiedBy: Long = 0
    var modifiedDate: LocalDateTime = LocalDateTime.now()
}