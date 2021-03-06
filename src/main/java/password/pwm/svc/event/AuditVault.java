/*
 * Password Management Servlets (PWM)
 * http://www.pwm-project.org
 *
 * Copyright (c) 2006-2009 Novell, Inc.
 * Copyright (c) 2009-2016 The PWM Project
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package password.pwm.svc.event;

import password.pwm.util.TimeDuration;

import java.util.Date;
import java.util.Iterator;

public interface AuditVault {

    void init(Settings settings);

    int size();

    Date oldestRecord();

    Iterator<AuditRecord> readVault();

    void add(AuditRecord record);

    class Settings {
        private long maxRecordCount;
        private TimeDuration maxRecordAge;


        public Settings(long maxRecordCount, TimeDuration maxRecordAge) {
            this.maxRecordCount = maxRecordCount;
            this.maxRecordAge = maxRecordAge;
        }

        public long getMaxRecordCount() {
            return maxRecordCount;
        }

        public TimeDuration getMaxRecordAge() {
            return maxRecordAge;
        }
    }

}
