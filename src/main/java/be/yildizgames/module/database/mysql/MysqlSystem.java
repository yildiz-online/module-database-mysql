/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2019 Grégory Van den Borre
 *
 *  More infos available: https://engine.yildiz-games.be
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 *  documentation files (the "Software"), to deal in the Software without restriction, including without
 *  limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 *  of the Software, and to permit persons to whom the Software is furnished to do so,
 *  subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all copies or substantial
 *  portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 *  WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 *  OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY CLAIM,
 *  DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  SOFTWARE.
 *
 */

package be.yildizgames.module.database.mysql;

import be.yildizgames.module.database.BaseDatabaseSystem;
import be.yildizgames.module.database.DatabaseConnectionProviderFactory;
import be.yildizgames.module.database.DriverProvider;
import be.yildizgames.module.database.QueryBuilder;
import com.mysql.cj.jdbc.Driver;
import org.jooq.SQLDialect;

import java.util.Calendar;

/**
 * @author Grégory Van den Borre
 */
public class MysqlSystem extends BaseDatabaseSystem {

    public static final String KEY = "mysql";

    private final DriverProvider provider = Driver::new;

    private MysqlSystem() {
        super("jdbc:mysql://${1}:${2}/${0}?zeroDateTimeBehavior=convertToNull&createDatabaseIfNotExist=true&nullNamePatternMatchesAll=true&useSSL=false&serverTimezone=" + Calendar.getInstance().getTimeZone().getID());
    }

    public static void support() {
        DatabaseConnectionProviderFactory.getInstance().addSystem(KEY, new MysqlSystem());
    }

    @Override
    public final SQLDialect getDialect() {
        return SQLDialect.MYSQL;
    }

    @Override
    public final String getDriver() {
        return "com.mysql.cj.jdbc.Driver";
    }

    @Override
    public final DriverProvider getDriverProvider() {
        return this.provider;
    }

    @Override
    public QueryBuilder createBuilder() {
        return new MySqlQueryBuilder();
    }

    @Override
    public boolean requirePool() {
        return true;
    }
}
