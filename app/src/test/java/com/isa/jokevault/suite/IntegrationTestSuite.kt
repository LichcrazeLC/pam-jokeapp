package com.isa.jokevault.suite

import com.isa.jokevault.EndpointPresenterCheck
import com.isa.jokevault.JokePresenterCheck
import org.junit.runner.RunWith
import org.junit.runners.Suite

// Runs all unit tests.
@RunWith(Suite::class)
@Suite.SuiteClasses(JokePresenterCheck::class, EndpointPresenterCheck::class)
class IntegrationTestSuite