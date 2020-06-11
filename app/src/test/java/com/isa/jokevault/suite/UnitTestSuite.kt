package com.isa.jokevault.suite

import com.isa.jokevault.InjectorCheck
import com.isa.jokevault.Default
import com.isa.jokevault.ServiceCheck
import org.junit.runner.RunWith
import org.junit.runners.Suite

// Runs all unit tests.
@RunWith(Suite::class)
@Suite.SuiteClasses(Default::class, ServiceCheck::class, InjectorCheck::class)
class UnitTestSuite