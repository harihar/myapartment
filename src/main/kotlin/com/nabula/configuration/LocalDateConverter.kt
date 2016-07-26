package com.nabula.configuration

import java.sql.Date
import java.time.LocalDate
import javax.persistence.AttributeConverter
import javax.persistence.Converter

/**
 * Created by harihar on 21/07/16.
 */
@Converter(autoApply = true)
class LocalDateConverter : AttributeConverter<LocalDate, Date> {
    override fun convertToDatabaseColumn(attribute: LocalDate?): Date? = Date.valueOf(attribute)

    override fun convertToEntityAttribute(dbData: Date?) = dbData?.toLocalDate()
}