/*******************************************************************************
 * Copyright (C) 2020 FVA GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package info.rexs.db.constants.standard;

import info.rexs.db.constants.RexsVersion;

/**
 * Standard REXS versions.
 *
 * @see RexsVersion
 * @see <a href="https://database.rexs.info/rexs/version/list">REXS Database</a>
 */
public interface RexsStandardVersions {
    /**
     * REXS version 1.0.
     */
    RexsVersion V1_0 = RexsVersion.create("1.0", 1000, "0.90", "0.10", "1.00");

    /**
     * REXS version 1.1.
     */
    RexsVersion V1_1 = RexsVersion.create("1.1", 1100, "1.10", "1.1-Beta");

    /**
     * REXS version 1.2.
     */
    RexsVersion V1_2 = RexsVersion.create("1.2", 1200);

    /**
     * REXS version 1.3.
     */
    RexsVersion V1_3 = RexsVersion.create("1.3", 1300);

    /**
     * REXS version 1.4.
     */
    RexsVersion V1_4 = RexsVersion.create("1.4", 1400);

    /**
     * REXS version 1.5.
     */
    RexsVersion V1_5 = RexsVersion.create("1.5", 1500);

    /**
     * REXS version 1.6.
     */
    RexsVersion V1_6 = RexsVersion.create("1.6", 1600);

    /**
     * Constant for an unknown version.
     */
    RexsVersion UNKNOWN = RexsVersion.create("unknown", -1);

    static void init() {
    }
}
