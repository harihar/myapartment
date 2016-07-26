package com.nabula.configuration

import java.sql.Timestamp
import java.time.LocalDateTime
import javax.persistence.AttributeConverter
import javax.persistence.Converter

/**
 * Created by harihar on 21/07/16.
 */
@Converter(autoApply = true)
class LocalDateTimeConverter : AttributeConverter<LocalDateTime, Timestamp> {
    override fun convertToDatabaseColumn(attribute: LocalDateTime?): Timestamp? = Timestamp.valueOf(attribute)

    override fun convertToEntityAttribute(dbData: Timestamp?) = dbData?.toLocalDateTime()
}