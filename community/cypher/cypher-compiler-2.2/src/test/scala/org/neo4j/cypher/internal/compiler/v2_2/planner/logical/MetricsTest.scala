/*
 * Copyright (c) 2002-2015 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.cypher.internal.compiler.v2_2.planner.logical

import org.neo4j.cypher.internal.commons.CypherFunSuite

class MetricsTest extends CypherFunSuite {

  test("negating a selectivity behaves as expected") {
    Selectivity(.1).negate should not equal Selectivity.ONE
    Selectivity(5.6e-17).negate should not equal Selectivity.ONE
    Selectivity(1e-300).negate should not equal Selectivity.ONE

    Selectivity.ZERO.negate should equal(Selectivity.ONE)
    Selectivity(0).negate should equal(Selectivity.ONE)

    Selectivity.ONE.negate should equal(Selectivity.ZERO)
    Selectivity(1).negate should equal(Selectivity.ZERO)

    Selectivity.CLOSEST_TO_ONE.negate should not equal Selectivity.ONE
  }

}
