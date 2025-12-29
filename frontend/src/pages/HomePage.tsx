export const HomePage = () => {
	return (
		<div className="px-4 py-8">
			<div className="bg-white rounded-lg shadow-md p-8 max-w-3xl mx-auto">
				<h1 className="text-4xl font-bold text-gray-900 mb-4">
					Development Starter Kit
				</h1>
				<p className="text-lg text-gray-600 mb-8">
					Spring Boot 3.x + Java 21 + React + TypeScript + Vite
				</p>

				<div className="space-y-3">
					<h2 className="text-xl font-semibold text-gray-800 mb-4">Tech Stack</h2>
					<div className="space-y-3">
						<div className="flex items-center p-3 bg-blue-50 rounded-lg border border-blue-100">
							<span className="text-blue-600 font-medium mr-2">Backend:</span>
							<span className="text-gray-700">Spring Boot 3.x with Java 21</span>
						</div>
						<div className="flex items-center p-3 bg-purple-50 rounded-lg border border-purple-100">
							<span className="text-purple-600 font-medium mr-2">Frontend:</span>
							<span className="text-gray-700">React with TypeScript and Vite</span>
						</div>
						<div className="flex items-center p-3 bg-green-50 rounded-lg border border-green-100">
							<span className="text-green-600 font-medium mr-2">Database:</span>
							<span className="text-gray-700">PostgreSQL</span>
						</div>
						<div className="flex items-center p-3 bg-red-50 rounded-lg border border-red-100">
							<span className="text-red-600 font-medium mr-2">Cache:</span>
							<span className="text-gray-700">Redis</span>
						</div>
						<div className="flex items-center p-3 bg-orange-50 rounded-lg border border-orange-100">
							<span className="text-orange-600 font-medium mr-2">Monitoring:</span>
							<span className="text-gray-700">Prometheus + Grafana</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	);
};
