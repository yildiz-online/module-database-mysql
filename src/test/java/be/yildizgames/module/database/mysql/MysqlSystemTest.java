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

import be.yildizgames.module.database.DataBaseConnectionProvider;
import be.yildizgames.module.database.DatabaseConnectionProviderFactory;
import be.yildizgames.module.database.DbProperties;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Grégory Van den Borre
 */
class MysqlSystemTest {

    @Nested
    class Support {

        @Disabled
        @Test
        void happyFlow() {
            MysqlSystem.support();
            DbProperties properties = new MysqlProperties();
            DataBaseConnectionProvider dcp = DatabaseConnectionProviderFactory.getInstance().create(properties);

            assertEquals("com.mysql.cj.jdbc.Driver", dcp.getDriver());
        }
    }

    private static final class MysqlProperties implements DbProperties {

        @Override
        public String getDbUser() {
            return "mysqlUser";
        }

        @Override
        public int getDbPort() {
            return 55;
        }

        @Override
        public String getDbPassword() {
            return "mysqlPwd";
        }

        @Override
        public String getDbHost() {
            return "localhost";
        }

        @Override
        public String getDbName() {
            return "test";
        }

        @Override
        public String getSystem() {
            return MysqlSystem.KEY;
        }

        @Override
        public String getDbRootUser() {
            return "root";
        }

        @Override
        public String getDbRootPassword() {
            return "rootPwd";
        }
    }
}
