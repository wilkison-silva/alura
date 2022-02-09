package br.com.alura.orgs.database.dao

import androidx.room.TypeConverter
import java.math.BigDecimal

class Converters {

    @TypeConverter
    fun deDoubleParaBigDecimal(double: Double?): BigDecimal {
//        return if(double != null){
//            BigDecimal(double.toString())
//        } else{
//            BigDecimal.ZERO
//        }

        return BigDecimal(double?.toString()) ?: BigDecimal.ZERO
    }

    @TypeConverter
    fun deBigDecimalParaDouble(bigDecimal: BigDecimal?): Double? {
//        return if(bigDecimal != null){
//            bigDecimal.toDouble()
//        } else{
//            null
//        }

        return bigDecimal?.toDouble()
    }
}