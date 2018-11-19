.PHONY: help ## This is to avoid make checking for any deps

.DEFAULT_GOAL := help  ## Just running make will run help target

help:
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'

test: ## Runs all cljs and clj tests, meant to be used by CI server
	npm install
	npx shadow-cljs compile ci-tests
	npx karma start --single-run
	lein do clean, test-refresh :run-once # clean is needed in case AOT stuff is around
