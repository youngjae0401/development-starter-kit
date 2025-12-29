import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';

import { HomePage } from '@/pages/HomePage';
import { UsersPage } from '@/pages/UsersPage';

function App() {
	return (
		<BrowserRouter>
			<div className="min-h-screen bg-gray-50">
				<nav className="bg-white shadow-sm border-b border-gray-200">
					<div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
						<div className="flex justify-between h-16">
							<div className="flex space-x-8">
								<Link
									to="/"
									className="inline-flex items-center px-1 pt-1 text-sm font-medium text-gray-900 hover:text-blue-600 transition-colors"
								>
									Home
								</Link>
								<Link
									to="/users"
									className="inline-flex items-center px-1 pt-1 text-sm font-medium text-gray-900 hover:text-blue-600 transition-colors"
								>
									Users
								</Link>
							</div>
						</div>
					</div>
				</nav>

				<main className="max-w-7xl mx-auto py-6 sm:px-6 lg:px-8">
					<Routes>
						<Route path="/" element={<HomePage />} />
						<Route path="/users" element={<UsersPage />} />
					</Routes>
				</main>
			</div>
		</BrowserRouter>
	);
}

export default App;
